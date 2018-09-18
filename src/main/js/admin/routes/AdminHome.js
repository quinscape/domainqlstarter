import React from "react"
import connect from "react-redux/es/connect/connect";

import {
    Link
} from "react-router-dom"


import {
    getUsers
} from "../reducers";

import {
    loadFooDetail,
    loadFoos,
    storeFoo
} from "../actions";


import Icon from "../../components/Icon";
/**
 * Protected route. While the Spring security roles are routed through to the entry point, it is often
 * preferable to control access control directly on the Spring Web MVC entry point or the general Spring security
 * configuration.
 *
 * You can also split the authenticated parts into their own end point, of course.
 */
class AdminHome extends React.Component {

    render()
    {
        const { users } = this.props;

        return (
            <div>
                <br/>
                <h1><Icon className="text-info fa-info-circle"/> Admin: Access controlled entry point </h1>
                <table className="table table-responsive table-hover table-striped">
                    <thead>
                        <tr>
                            <th>Login</th>
                            <th>Roles</th>
                            <th>Created</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        users.map( user => (
                            <tr key={ user.id }>
                                <td>
                                    { user.login }
                                </td>
                                <td>
                                    { user.roles }
                                </td>
                                <td>
                                    { user.created }
                                </td>
                                <td>
                                    <div className="btn-toolbar">
                                        <button
                                            type="button"
                                            className="btn btn-secondary mr-1"
                                            onClick={ ev => alert("Not actually deleted") }
                                        >
                                            <Icon className="fa-trash-alt"/>
                                            {
                                                " Delete"
                                            }

                                        </button>
                                        <Link
                                            className="btn btn-primary"
                                            to={ "/admin/user/" + user.login }
                                        >
                                            <Icon className="fa-edit"/>
                                            {
                                                " Details"
                                            }
                                        </Link>
                                    </div>
                                </td>
                            </tr>
                        ))
                    }
                    </tbody>

                </table>
            </div>
        )
    }
}


const mapStateToProps = state => {
    return {
        users: getUsers(state),
    }
};

const mapDispatchToProps = ({
    loadFoos,
    loadFooDetail,
    storeFoo
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(AdminHome)

