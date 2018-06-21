import React from "react"
import {
    NavLink as RouterNavLink,
    Route,
    Switch
} from "react-router-dom"

import {
    ListGroup,
    ListGroupItem
} from "reactstrap"
import {
    loadFoos,
    loadFooDetail,
    storeFoo,
    FOO_PAGING
} from "../actions";
import { getFoos, getFooDetail, getFooRowCount } from "../reducers";
import Icon from "../../components/Icon";

import { connect } from "react-redux"
import FooForm from "./FooForm";

import FOO_EDITOR_CSS from "./foo-editor.css"
import urlSafe from "../../util/urlSafe";

class FooAdmin extends React.Component {

    state = {
        offset: 0,
        fooDetail: null
    };

    componentDidMount()
    {
        this.props.loadFoos(this.state.offset);

        const { id } = this.props.match.params;
        if (id)
        {
            this.props.loadFooDetail(id);
        }
    }

    componentDidUpdate(prevProps, prevState)
    {

        const prevId = prevProps.match.params.id;
        const id = this.props.match.params.id;

        if (id !==  prevId)
        {
            this.props.loadFooDetail(id);
        }

    }
    
    setOffset = ev => {

        const offset = +ev.target.dataset.offset;

        this.props.loadFoos(offset).then( () =>  this.setState({ offset }));
    };

    onSubmit = (foo, actions) => {

        console.log("SUBMIT", foo);

        return this.props.storeFoo(foo);
    };

    render()
    {
        const { offset } = this.state;

        // provided by connect() below
        const { foos, fooDetail, rowCount } = this.props;

        const prevOffset = offset - FOO_PAGING;
        const nextOffset = offset + FOO_PAGING;

        return (
            <React.Fragment>
                <div className="row">
                    <div className="col">
                        <h1> Foo Admin </h1>
                    </div>
                </div>
                <hr/>
                <div className="row">
                    <div className="col-md-4">
                        {
                            foos && (
                                <React.Fragment>
                                    <ListGroup>
                                        {
                                            foos.length === 0 && "No Foos"
                                        }
                                        {
                                            foos.map( foo => (
                                                <ListGroupItem
                                                    key={ foo.id }
                                                    active={fooDetail && fooDetail.id === foo.id}
                                                >
                                                    <RouterNavLink
                                                        className="btn"
                                                        disabled={ true }
                                                        to={ "/app/foo/" + foo.id + "/" + urlSafe(foo.name) }
                                                    >
                                                        { foo.name }
                                                    </RouterNavLink>
                                                </ListGroupItem>
                                            ))
                                        }
                                    </ListGroup>
                                    <div className="fa-pull-right">

                                        <button
                                            type="button"
                                            onClick={ this.setOffset }
                                            className="btn btn-secondary"
                                            disabled={prevOffset < 0}
                                            data-offset={ prevOffset }
                                        >
                                            <Icon
                                                className="fa-arrow-left"
                                            />
                                        </button>
                                        {" "}
                                        <button
                                            type="button"
                                            className="btn btn-secondary"
                                            disabled={ nextOffset >= rowCount }
                                            onClick={ this.setOffset }
                                            data-offset={ nextOffset }
                                        >
                                            <Icon
                                                className="fa-arrow-right"
                                            />
                                        </button>
                                    </div>
                                </React.Fragment>
                            )
                        }
                    </div>
                    <div className="col-md-8">

                        {
                            fooDetail &&
                            <FooForm
                                key={ fooDetail.id }
                                value={ fooDetail }
                                onSubmit={ this.onSubmit }
                            />
                        }
                    </div>
                </div>

            </React.Fragment>
        )
    }
}

const mapStateToProps = state => {
    return {
        foos: getFoos(state),
        rowCount: getFooRowCount(state),
        fooDetail: getFooDetail(state)
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
    )(FooAdmin)

/**
 (
 <FooForm
 key={ fooDetail.id }
 value={ fooDetail }
 />
 )
 */
