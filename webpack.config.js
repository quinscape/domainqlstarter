const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const PreloadQueriesPlugin = require("domainql-webpack-plugin");
const JsViewPlugin = require("jsview-webpack-plugin");
const TrackUsagePlugin = require("babel-plugin-track-usage/webpack/track-usage-plugin");

const path = require("path");
const fs = require("fs");
const webpack = require("webpack");
const shelljs = require("shelljs");

const PRODUCTION = (process.env.NODE_ENV === "production");

// TODO: change "domainqlstarter" to actual project name
const JS_OUTPUT_DIRECTORY = path.join(__dirname, "target/domainqlstarter/js/");

if (!fs.existsSync(JS_OUTPUT_DIRECTORY))
{
    shelljs.mkdir("-p", JS_OUTPUT_DIRECTORY);
}

module.exports = {
    mode: process.env.NODE_ENV,
    entry: {
        main: "./src/main/js/main/main.js",
        admin: "./src/main/js/admin/admin.js",
        login: "./src/main/js/login.js"
    },

    devtool: "source-map",

    output: {
        // hard-coded target path for now ( pom.xml defines build.finalName as domainqlstarter)
        path: JS_OUTPUT_DIRECTORY,
        filename: "bundle-[name]-[chunkhash].js",
        chunkFilename: "bundle-[id]-[chunkhash].js",
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: "bundle-[name]-[chunkhash].css",
            chunkFilename: "bundle-[id]-[chunkhash].css"
        }),

        new webpack.DefinePlugin({
            "__PROD": PRODUCTION,
            "__DEV": !PRODUCTION,
            "process.env.NODE_ENV": JSON.stringify(PRODUCTION ? "production" : "development")
        }),

        // clean old assets and generate webpack-assets.json
        new JsViewPlugin(),
        new PreloadQueriesPlugin({
            //debug: true
        }),
        new TrackUsagePlugin({
            output: path.join( JS_OUTPUT_DIRECTORY, "/track-usage.json")
        })
    ],

    module: {
        rules: [
            // babel transpilation ( see .babelrc for babel config)
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            },

            // this is just concatenating the .css modules in components to one bundle.
            // No postprocessing of that.
            {
                test: /\.css$/,
                exclude: /node_modules/,
                use: [ MiniCssExtractPlugin.loader, "css-loader" ]
            }
        ]
    },

    optimization: {
        splitChunks: {
            cacheGroups: {
                commons: { test: /[\\/]node_modules[\\/]/, name: "vendors", chunks: "all" }
            }
        }
    }
};
