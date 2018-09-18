import React from "react"

import cx from "classnames"
import Field from "domainql-form/lib/Field";
import TextArea from "domainql-form/lib/TextArea";
import withForm from "domainql-form/lib/withForm";
import FieldMode from "domainql-form/lib/FieldMode";
import GlobalErrors from "domainql-form/lib/GlobalErrors";
import Icon from "../../components/Icon";
import config from "../../services/config";
import hasRole from "../../util/hasRole";

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
import findIndexById from "../../util/findIndexById";
/**
 * Protected route. While the Spring security roles are routed through to the entry point, it is often
 * preferable to control access control directly on the Spring Web MVC entry point or the general Spring security
 * configuration.
 *
 * You can also split the authenticated parts into their own end point, of course.
 */
class AdminDetail extends React.Component {

    render()
    {
        const { formConfig } = this.props;

        const { formikProps } = formConfig;

        const {isValid, values, errors} = formikProps;


        return (
            <React.Fragment>
                <GlobalErrors/>
                <Field name="name"/>
                <Field name="roles"/>
                <Field name="disabled"/>
                <Field name="created" mode={ FieldMode.READ_ONLY }/>
            </React.Fragment>
        )
    }
}

const AdminDetailWithForm = withForm(AdminDetail, {
    type: "AppUserInput"
});

const mapStateToProps = (state, ownProps) => {

    const { id  } = ownProps.match.params;

    return {
        value: findIndexById(getUsers(state), id)
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
)(AdminDetailWithForm)

