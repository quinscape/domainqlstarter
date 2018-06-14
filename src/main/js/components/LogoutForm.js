import React from "react"

import config from "../services/config"
import Icon from "./Icon";

/**
 * A CSRF-protection-compliant Spring security log out-form
 */
class LogoutForm extends React.Component {

    render()
    {
        const { authentication, csrfToken } = config();

        return (
            <form method="POST" action="/logout" className="form-inline fa-pull-right">
                { "Logged in as\u00a0" }
                <span className="text-info">
                    <Icon className="fa-user"/>
                    { " " + authentication.login }
                </span>
                {
                    authentication.login !== "anonymous" &&
                        <React.Fragment>
                            :
                            <button type="submit" className="btn btn-link ">
                                Log out
                            </button>
                        </React.Fragment>
                }
                <input type="hidden" name={ csrfToken.param } value={ csrfToken.value }/>
            </form>
        )
    }
}

export default LogoutForm
