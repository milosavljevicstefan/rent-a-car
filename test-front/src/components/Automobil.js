import React from 'react';
import {Button, ButtonGroup, Table, Form, Collapse} from 'react-bootstrap';
import AppAxios from '../api/AppAxios';

class Automobil extends React.Component {

    constructor() {
        super();
        this.state = { 
            automobili: [],
            model: "",
            pageNo: 0,
            totalPages: 1,
            open: false
        }
    }

    componentDidMount() {
        this.getAutomobili(0);
        console.log(this.state);
    }

    getAutomobili(newPageNo) {
        var params = {
            'model': this.state.model,
            'pageNo': newPageNo
        }
        AppAxios.get('/automobili', {params})
            .then(res => {
                console.log(res);
                console.log(res.data);
                this.setState({
                    automobili: res.data,
                    pageNo: newPageNo,
                    totalPages: res.headers['total-pages']
                });
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            });
    }

    iznajmi(id) {
        let params = {
            automobilId: id,
            username: window.localStorage['username']
        }

        AppAxios.post('/najam', params)
            .then(res => {
                console.log(res);
                alert("Vaš auto je uspešno iznajmljen!");
                window.location.reload();
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })
    }

    renderAutomobili() {
        return this.state.automobili.map((automobil, index) => {
            return (
                <tr key={automobil.id}>
                    <td>{automobil.model}</td>
                    <td>{automobil.registracija}</td>
                    <td>{automobil.godiste}</td>
                    <td>{automobil.potrosnja}</td>
                    <td>{automobil.kompanijaNaziv}</td>
                    {window.localStorage['role']=="ROLE_ADMIN"?
                    [<td><Button variant="danger" onClick={() => this.delete(automobil.id)}>Obriši</Button></td>,
                    <td><Button variant="warning" onClick={() => this.goToEdit(automobil.id)}>Izmeni</Button></td>]
                    : null}
                    {automobil.iznajmljen == true ?
                    <td><Button variant="success" disabled onClick={() => this.iznajmi(automobil.id)}>Iznajmi</Button></td>
                    :<td><Button variant="success" onClick={() => this.iznajmi(automobil.id)}>Iznajmi</Button></td>}
                </tr>
            )
        })
    }

    delete(id) {
        AppAxios.delete('/automobili/' + id)
            .then(res => {
                console.log(res);
                window.location.reload();
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })
    }

    onChangeHandler(event) {
        let name = event.target.name;
        let value = event.target.value;

        let change = {};
        change[name] = value;
        console.log(change);
        this.setState(change);
    }

    goToAdd() {
        this.props.history.push('/automobili/dodaj');
    }

    goToEdit(id) {
        this.props.history.push('/automobili/izmeni/' + id);
    }

    render() {
        const open = this.state.open;
        return (
            <div>
                <div>
                <Button 
                variant="primary"
                onClick={() => this.setState({open: !open})}
                aria-controls="formForSearch"
                aria-expanded={open}>
                    Filter
                </Button>
                <Collapse in={this.state.open}>
                    <div id="formForSearch">
                        <Form>
                            {/* <Form.Label htmlFor="value">Value</Form.Label> */}
                            <Form.Control type="text" name="model" placeholder="Model" onChange={(e) => this.onChangeHandler(e)}></Form.Control>
                            <Button variant="success" onClick={() => this.getAutomobili(0)}>Search</Button>
                        </Form>
                    </div>
                </Collapse>
                <div>
                    <ButtonGroup>
                        <Button disabled={this.state.pageNo===0} onClick={()=> this.getAutomobili(this.state.pageNo-1)}>Prev</Button>
                        <Button disabled={this.state.pageNo===this.state.totalPages-1} onClick={()=> this.getAutomobili(this.state.pageNo+1)}>Next</Button>
                    </ButtonGroup>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>Model</th>
                                <th>Registracija</th>
                                <th>Godište</th>
                                <th>Potrošnja</th>
                                <th>Kompanija</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderAutomobili()}
                        </tbody>
                    </Table>
                    <br/>
                    {window.localStorage['role'] == "ROLE_ADMIN"?<Button variant="primary" onClick={() => this.goToAdd() }>Add new</Button>:null}
                </div>
            </div>
            </div>
        )
    }
}

export default Automobil;