import React from "react"
import cx from "classnames"
import FormConfigProvider from "domainql-form/lib/FormConfigProvider";
import Field from "domainql-form/lib/Field";
import TextArea from "domainql-form/lib/TextArea";
import withForm from "domainql-form/lib/withForm";
import Form from "domainql-form/lib/Form";
import FormBlock from "domainql-form/lib/FormBlock";
import FieldMode from "domainql-form/lib/FieldMode";
import GlobalErrors from "domainql-form/lib/GlobalErrors";

import {
    Button,
    Container,
    Row,
    Col
} from "reactstrap";
import StaticText from "domainql-form/lib/StaticText";
import Icon from "../../components/Icon";
import config from "../../services/config";
import hasRole from "../../util/hasRole";


class FooForm extends React.Component {

    render()
    {
        const { authentication } = config();

        const { schema, control, foo, formConfig} = this.props;

        const { formikProps } = formConfig;

        const {isValid, isSubmitting, values, errors} = formikProps;

        console.log({
            isValid,
            values,
            errors
        });

        /*
        input FooInput {
          id: String!
          name: String!
          description: String
          type: Int!
          num: Int!
          created: Timestamp!
          owner: String!
        }
        */

        // for our badly secured frontend, we just change the color of the button and do
        // not disable it like we should.
        const canAccess = authentication.id === values.ownerId || hasRole("ROLE_ADMIN");

        return (
            <React.Fragment>
                <GlobalErrors/>
                <Field name="name"/>
                <TextArea name="description"/>
                <Field name="num"/>

                <div>
                    <button
                        type="reset"
                        className="btn btn-secondary"
                    >
                        <Icon className="fa-recycle"/>
                        { " " }
                        Reset
                    </button>
                    { " " }
                    <button
                        type="submit"
                        className={
                            cx(
                                "btn",
                                canAccess ? "btn-success" : "btn-danger"
                            )
                        }
                    >
                        <Icon className="fa-save"/>
                        { " " }
                        Save
                    </button>
                </div>
            </React.Fragment>
        );
    }
}

export default withForm(
    FooForm,
    {
        type: "FooInput"
    }
);


