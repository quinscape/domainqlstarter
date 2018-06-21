import React from "react"

import rootReducer from "./reducers/index"
import FormConfigProvider from "domainql-form/lib/FormConfigProvider"

import storeFactory from "../services/store-factory"
import bootstrap from "jsview-bootstrap"
import createHistory from "history/createBrowserHistory";
import App from "./App";
import config, { __initConfig } from "../services/config";


const history = createHistory();

bootstrap(
    initial => {

        console.info("INITIAL DATA", initial);

        __initConfig(initial, ["contextPath", "authentication", "csrfToken"]);

        const store = storeFactory(
            rootReducer,
            initial,
            history
        );

        // We need to tell webpack from where to load dynamically imported modules
        // noinspection JSUndeclaredVariable
        __webpack_public_path__ = config().contextPath + "/js/";

        return (
            <FormConfigProvider
                schema={ initial.schema }
            >
                <App
                    store={store}
                    history={history}
                />
            </FormConfigProvider>
        );
    },
    () => console.info("ready!")
);
