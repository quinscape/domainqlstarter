import React from "react"

import rootReducer from "./reducers"

import storeFactory from "./services/store-factory"
import bootstrap from "jsview-bootstrap"
import createHistory from "history/createBrowserHistory";
import App from "./components/App";

const history = createHistory();

bootstrap(
    function (initial) {

        // We need to tell webpack from where to load dynamically imported modules
        // noinspection JSUndeclaredVariable

        const store = storeFactory(rootReducer, initial, history);

        __webpack_public_path__ = initial.contextPath + "/js/";
        return (
            <App
                store={store}
                history={ history }
            />
        );
    },
    () => console.info("ready!")
);

