import React from 'react';
import { Form, Row, Col, Button, FormGroup, FormLabel, FormControl} from 'react-bootstrap';
import AppAxios from '../api/AppAxios';


class EditAutomobil extends React.Component {

    constructor() {
        super();

        this.state = {
            id: '',
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
        this.setState({id: this.props.match.params.id});
        this.getAutomobilById(this.props.match.params.id);
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

    getAutomobilById(id) {
        AppAxios.get('/automobili/' + id)
            .then(res => {
                console.log(res)
                this.setState({
                    model: res.data.model,
                    registracija: res.data.registracija,
                    godiste: res.data.godiste,
                    potrosnja: res.data.potrosnja,
                    kompanijaId: res.data.kompanijaId,
                    kompanijaNaziv: res.data.kompanijaNaziv
                })
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            })
    }

    edit() {
        let params = {
            'id': this.state.id,
            'model': this.state.model,
            'registracija': this.state.registracija,
            'godiste': this.state.godiste,
            'potrosnja': this.state.potrosnja,
            'kompanijaId': this.state.kompanijaId,
            'kompanijaNaziv': this.state.kompanijaNaziv
        };

        AppAxios.put('/automobili/' + this.props.match.params.id, params)
            .then(res => {
                console.log(res);
                this.props.history.push('/automobili');
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

        this.setState(change);
    }

    render() {
        return (
             <div>
                <Row>
                    <Col></Col>
                    <Col>
                        <h1>Izmeni Automobil</h1>
                        <Form>
                            <Form.Label htmlFor="model">Model</Form.Label>
                            <Form.Control type="text" id="model" name="model" onChange={(e) => this.onChangeHandler(e)} value={this.state.model}></Form.Control>
                            <Form.Label htmlFor="registracija">Registracija</Form.Label>
                            <Form.Control type="text" id="registracija" name="registracija" onChange={(e) => this.onChangeHandler(e)} value={this.state.registracija}></Form.Control>
                            <Form.Label htmlFor="godiste">Godiste</Form.Label>
                            <Form.Control type="number" id="godiste" name="godiste" onChange={(e) => this.onChangeHandler(e)} value={this.state.godiste}></Form.Control>
                            <Form.Label htmlFor="potrosnja">Potrosnja</Form.Label>
                            <Form.Control type="number" id="potrosnja" name="potrosnja" onChange={(e) => this.onChangeHandler(e)} value={this.state.potrosnja}></Form.Control>
                            <Form.Label htmlFor="model">Kompanija</Form.Label>
                            <FormControl as="select" id="kompanijaId" name="kompanijaId" onChange={(e) => this.onChangeHandler(e)} value={this.state.kompanijaId}>
                                    <option></option>
                                    {
                                        this.state.kompanije.map((kompanija) => {
                                            return (
                                                <option key={kompanija.id} value={kompanija.id}>{kompanija.naziv}</option>
                                            )
                                        })
                                    }
                                </FormControl>
                            <Button variant="primary" onClick={() => this.edit()}>izmeni</Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </div>
        )
    }
}

export default EditAutomobil;