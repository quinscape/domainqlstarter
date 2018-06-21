import React from "react"

import config from "../services/config"
import Icon from "./Icon";

/**
 * A CSRF-protection-compliant Spring security log out-form
 */
class LogoutForm extends React.Component {

    render()
    {
        const { authentication , csrfToken } = config();

        const { login } = authentication;

        const isAnonymous = login === "anonymous";

        let jsonTitle = null;
        if (process.env.NODE_ENV !== "production")
        {
            jsonTitle = JSON.stringify(authentication);
        }

        return (
            <React.Fragment>
                {
                    !isAnonymous ?
                    <form method="POST" action="/logout" className="form-inline fa-pull-right">
                        { "Logged in as\u00a0" }
                        <span className="text-info">
                        <Icon className="fa-user" title={ jsonTitle }/>
                            { " " + login }
                    </span>
                        :
                        <button type="submit" className="btn btn-link ">
                            Log out
                        </button>
                        <input type="hidden" name={ csrfToken.param } value={ csrfToken.value }/>
                    </form>
                    :
                    <Icon className="fa-user" title={ jsonTitle }/>
                }
            </React.Fragment>
        )
    }
}

export default LogoutForm
