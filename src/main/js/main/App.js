import React from "react";

import { Provider } from "react-redux"

import {
    NavLink as RouterNavLink,
    Route,
    Switch
} from "react-router-dom"

import { ConnectedRouter } from 'connected-react-router'
import {
    Collapse,
    Container,
    Nav,
    Navbar,
    NavbarBrand,
    NavbarToggler,
    NavItem,
} from "reactstrap"

import LazyLoader from "./routes/LazyLoader";
import About from "./routes/About";
import Home from "./routes/Home";
import FooAdmin from "./routes/FooAdmin";
import Admin from "./routes/Admin";
import LogoutForm from "../components/LogoutForm";

class App extends React.Component {

    state = {
        isNavExpanded: false
    };

    toggle = () => this.setState({isNavExpanded: !this.state.isNavExpanded});

    render()
    {
        const {store, history} = this.props;
        const { foos, isNavExpanded } = this.state;

        return (
            <Provider store={ store }>
                <ConnectedRouter history={ history }>
                    <Container fluid={ false }>
                        <Navbar color="dark" dark expand="md">

                            {/* TODO: replace branding */}
                            <NavbarBrand href="/">domainqlstarter</NavbarBrand>
                            <NavbarToggler onClick={ this.toggle }/>
                            <Collapse isOpen={ isNavExpanded } navbar>
                                <Nav className="ml-auto" navbar>
                                    <NavItem>
                                        <RouterNavLink
                                            className="nav-link"
                                            to="/app/lazy/"
                                        >
                                            Lazy
                                        </RouterNavLink>
                                    </NavItem>
                                    <NavItem>
                                        <RouterNavLink
                                            className="nav-link"
                                            to="/app/foo/"
                                        >
                                            Foo Admin
                                        </RouterNavLink>
                                    </NavItem>
                                    <NavItem>
                                        <RouterNavLink
                                            className="nav-link"
                                            to="/app/about/"
                                        >
                                            About
                                        </RouterNavLink>
                                    </NavItem>
                                    <NavItem>
                                        <a
                                            className="btn nav-link"
                                            href="/admin/"
                                        >
                                            Admin
                                        </a>
                                    </NavItem>
                                </Nav>
                            </Collapse>
                        </Navbar>
                        <Switch>
                            <Route exact path="/app/" component={ Home }/>
                            <Route exact path="/app/foo/" component={ FooAdmin }/>
                            <Route path="/app/foo/:id/:name" component={ FooAdmin }/>
                            <Route path="/app/lazy" component={ LazyLoader }/>
                            <Route path="/app/about" component={ About }/>
                            <Route path="/app/admin" component={ Admin }/>
                        </Switch>
                        <hr/>
                        <div>
                            <LogoutForm/>
                        </div>

                    </Container>
                </ConnectedRouter>
            </Provider>
        )
    }
}


export default App

