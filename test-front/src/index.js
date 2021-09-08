import React from 'react';
import ReactDOM from 'react-dom';
import { Route, HashRouter as Router, Switch, Link } from 'react-router-dom';
import { Navbar, Nav, Button } from 'react-bootstrap';
import Home from './components/Home';
import 'bootstrap/dist/css/bootstrap.min.css';
import NotFound from './NotFound';
import Login from './components/Login';
import {logout} from './services/auth';
import Automobil from './components/Automobil';
import AddAutomobil from './components/AddAutomobil';
import EditAutomobil from './components/EditAutomobil';

class App extends React.Component {

    render() {
        return (
            <div>
                <Navbar bg="primary" expand="lg">
                    <Navbar.Brand href="#">Home</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="mr-auto">
                            {/* <Nav.Link href="#linije">Linije</Nav.Link>
                            <Nav.Link href="#prevoznici">Prevoznici</Nav.Link> */}
                            <Nav.Link href="#automobili">Automobili</Nav.Link>
                            {window.localStorage['jwt'] ?
                             <Button onClick = {() => logout()}>Log out</Button> :
                             <Nav.Link href="#login">Log in</Nav.Link>} 
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
                <Router>
                    <Switch>
                        <Route exact path="/" component={Home} />
                        <Route exact path="/login" component={Login} />
                        <Route exact path="/automobili" component={Automobil} />
                        <Route exact path="/automobili/dodaj" component={AddAutomobil} />
                        <Route exact path="/automobili/izmeni/:id" component={EditAutomobil} />
                        <Route component={NotFound} />
                    </Switch>
                </Router>
            </div>
        );
    }
};

ReactDOM.render(
    <App/>,
    document.querySelector('#root')
);
