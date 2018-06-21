const s = "import React from \"react\"\n" +
    "\n" +
    "import rootReducer from \"./reducers\"\n" +
    "\n" +
    "import storeFactory from \"./services/store-factory\"\n" +
    "import bootstrap from \"jsview-bootstrap\"\n" +
    "import createHistory from \"history/createBrowserHistory\";\n" +
    "import App from \"./components/App\";\n" +
    "import { initConfig } from \"./services/config\";\n" +
    "\n" +
    "\n" +
    "const history = createHistory();\n" +
    "\n" +
    "bootstrap(\n" +
    "    function (initial) {\n" +
    "\n" +
    "        initConfig(initial);\n" +
    "\n" +
    "        const store = storeFactory(\n" +
    "            rootReducer,\n" +
    "            initial,\n" +
    "            history\n" +
    "        );\n" +
    "\n" +
    "        // We need to tell webpack from where to load dynamically imported modules\n" +
    "        // noinspection JSUndeclaredVariable\n" +
    "        __webpack_public_path__ = initial.contextPath + \"/js/\";\n" +
    "\n" +
    "        return (\n" +
    "            <App\n" +
    "                store={store}\n" +
    "                history={history}\n" +
    "            />\n" +
    "        );\n" +
    "    },\n" +
    "    () => console.info(\"ready!\")\n" +
    ");\n" +
    "\n" +
    "export const PRELOADED_QUERIES = {\n" +
    "    // language=GraphQL\n" +
    "    preloadedUsers: `{\n" +
    "        users{\n" +
    "            id\n" +
    "            login\n" +
    "            disabled\n" +
    "            created\n" +
    "            lastLogin\n" +
    "            roles\n" +
    "        }\n" +
    "    }\n" +
    "    `\n" +
    "};\n";


function removeComments(source)
{
    return (
        source
            .replace(/\/\*[\S\s]*?\*\//gm, "")
            .replace(/^(.*?)\/\/.*$/gm, "$1")
    );
}


console.log(removeComments(s));
