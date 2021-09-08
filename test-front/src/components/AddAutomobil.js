import React from 'react';
import { Form, Row, Col, Button, FormGroup, FormLabel, FormControl} from 'react-bootstrap';
import AppAxios from '../api/AppAxios';

class AddAutomobil extends React.Component {

    constructor() {
        super();

        this.state = {
            model: '',
            registracija: '',
            godiste: 0,
            potrosnja: '',
            kompanijaId: '',
            kompanijaNaziv: '',
            kompanije: []
        }
    }

    componentDidMount() {
        this.getKompanije();
    }

    getKompanije() {
        AppAxios.get('/kompanije')
            .then(res => {
                console.log(res);
                this.setState({
                    kompanije: res.data
                });
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })
    }

    create() {
        let params = {
            model: this.state.model,
            registracija: this.state.registracija,
            godiste: this.state.godiste,
            potrosnja: this.state.potrosnja,
            kompanijaId: this.state.kompanijaId,
            kompanijaNaziv: this.state.kompanijaNaziv
        }

        AppAxios.post('/automobili', params)
            .then(res => {
                console.log(res);
                this.props.history.push('/automobili');
            })
            .catch(error => {
                console.log(error);
                alert("Error");
            })
    }

    onChangeHandler(event) {
        let name = event.target.name;
        let value = event.target.value;

        let change = {};
        change[name] = value;

        this.setState(change);
    }

    render() {

        return (
            <div>
                <Row>
                    <Col></Col>
                    <Col>
                        <h1>Dodaj Automobil</h1>
                        <Form>
                            <Form.Label htmlFor="model">Model</Form.Label>
                            <Form.Control type="text" id="model" name="model" onChange={(e) => this.onChangeHandler(e)}></Form.Control>
                            <Form.Label htmlFor="registracija">Registracija</Form.Label>
                            <Form.Control type="text" id="registracija" name="registracija" onChange={(e) => this.onChangeHandler(e)}></Form.Control>
                            <Form.Label htmlFor="godiste">Godiste</Form.Label>
                            <Form.Control type="number" id="godiste" name="godiste" onChange={(e) => this.onChangeHandler(e)}></Form.Control>
                            <Form.Label htmlFor="potrosnja">Potrosnja</Form.Label>
                            <Form.Control type="number" id="potrosnja" name="potrosnja" onChange={(e) => this.onChangeHandler(e)}></Form.Control>
                            <Form.Label htmlFor="model">Kompanija</Form.Label>
                            <FormControl as="select" id="kompanijaId" name="kompanijaId" onChange={(e) => this.onChangeHandler(e)}>
                                    <option></option>
                                    {
                                        this.state.kompanije.map((kompanija) => {
                                            return (
                                                <option key={kompanija.id} value={kompanija.id}>{kompanija.naziv}</option>
                                            )
                                        })
                                    }
                                </FormControl>
                            <Button variant="primary" onClick={() => this.create()}>Dodaj</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </div>
        )
    }
}

export default AddAutomobil;