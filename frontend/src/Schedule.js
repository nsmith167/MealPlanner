import React, { Component } from 'react';
import './App.scss';
import AppNavbar from './AppNavbar';
import { Container, ListGroup, ListGroupItem, Row, Col, Button } from 'reactstrap'


class Schedule extends Component {

    constructor(props) {
        super(props);
        this.state = {schedule: [], isLoading : true};

        this.generateNewSchedule = this.generateNewSchedule.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('/schedule')
            .then(response => response.json())
            .then(data => this.setState({schedule: data, isLoading: false}));
    }

    async generateNewSchedule() {
        this.setState({isLoading: true});

        await fetch('/schedule/new')
                .then(response => response.json())
                .then(data => this.setState({schedule: data, isLoading: false}));
    }

    render() {

        const {schedule, isLoading} = this.state;


        console.log(schedule);
        if (isLoading) {
            return <p>Loading...</p>;
        }

        const scheduleDisplay = schedule.days.map(day => {
            return <div class="schedule-day">
                <h3>{day.day}</h3>
                <ListGroup>
                    <ListGroupItem tag="a" href={'/recipe-view/' + day.breakfast.id} action>{day.breakfast.name}</ListGroupItem>
                    <ListGroupItem tag="a" href={'/recipe-view/' + day.amSnack.id} action>{day.amSnack.name}</ListGroupItem>
                    <ListGroupItem tag="a" href={'/recipe-view/' + day.lunch.id} action>{day.lunch.name}</ListGroupItem>
                    <ListGroupItem tag="a" href={'/recipe-view/' + day.pmSnack.id} action>{day.pmSnack.name}</ListGroupItem>
                    <ListGroupItem tag="a" href={'/recipe-view/' + day.dinner.id} action>{day.dinner.name}</ListGroupItem>
                    <ListGroupItem tag="a" href={'/recipe-view/' + day.nightSnack.id} action>{day.nightSnack.name}</ListGroupItem>
                </ListGroup>
            </div>
        });
        
        return (
            <div>
                <AppNavbar />
                <Container>
                    <h1>Meal Schedule</h1>
                    {scheduleDisplay}
                    <div class="new-schedule-button">
                        <Button color="primary" onClick={this.generateNewSchedule}>New Schedule</Button>
                    </div>                   
                </Container>
            </div>
        );
    }
}

export default Schedule;