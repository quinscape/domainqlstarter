import React from "react"
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


class FooForm extends React.Component {

    render()
    {
        const {schema, control, foo, formConfig} = this.props;

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
                        className="btn btn-primary"
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


