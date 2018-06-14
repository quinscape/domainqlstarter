import { routerMiddleware } from "react-router-redux";
import { applyMiddleware, createStore } from "redux";
import { initConfig } from "./config";


/**
 * Factory to create the actual redux store. Can be modified to apply local middle ware
 *
 * @param {function} rootReducer    root reducer function
 * @param initialState              initial redux state
 * @param history                   history object
 * 
 * @return {Store<any> & {dispatch: any}}
 */
export default function (rootReducer, initialState, history)
{
    initConfig(initialState);

    // Build the middleware for intercepting and dispatching navigation actions
    const middleware = routerMiddleware(history);

    // Add the reducer to your store on the `router` key
    // Also apply our middleware for navigating
    return createStore(
        rootReducer,
        initialState,
        applyMiddleware(middleware)
    );
}
