import React, { Component, useState } from 'react';
import './App.scss';
import './RecipeForm.scss';
import AppNavbar from './AppNavbar';
import {Link, withRouter} from 'react-router-dom';
import { Container, Form, FormGroup, Label, Input, Button, Col } from 'reactstrap'
import MultiSelect from "react-multi-select-component";


class RecipeForm extends Component {

    emptyRecipe = {
        name: '',
        recipeTypes: [],
        instructions: '',
        ingredients: '',
    };

    recipeTypeOptions = [
        {label: "Breakfast", value: "BREAKFAST"},
        {label: "AM Snack", value: "AM_SNACK"},
        {label: "Lunch", value: "LUNCH"},
        {label: "PM Snack", value: "PM_SNACK"},
        {label: "Dinner", value: "DINNER"},
        {label: "Night Snack", value: "NIGHT_SNACK"}
    ]

    constructor(props) {
        super(props);
        this.state = {
            recipe: this.emptyRecipe,
            selectedRecipeTypeOptions: []
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleMultiSelectChange = this.handleMultiSelectChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {
            const returnedRecipe = await (await fetch(`/recipes/recipe/${this.props.match.params.id}`)).json();
            this.setState({recipe: returnedRecipe, selectedRecipeTypeOptions: this.recipeTypeOptions.filter(type => returnedRecipe.recipeTypes.includes(type["value"]))});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let recipe = {...this.state.recipe};
        recipe[name] = value;
        this.setState({recipe});
    }

    handleMultiSelectChange(event) {
        let recipe = {...this.state.recipe};
        recipe["recipeTypes"] = event.map(selection => selection["value"]);
        this.setState({recipe, selectedRecipeTypeOptions: event});
    }

    async handleDelete(event) {
        event.preventDefault();
        const {recipe} = this.state;

        if (window.confirm('Are you sure you want to delete this recipe?')) {
            await fetch('/recipes/recipe/' + recipe.id, {
                method: 'DELETE',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            });
            this.props.history.push('/');
        }
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {recipe} = this.state;
        await fetch('/recipes/recipe' + (recipe.id ? '/' + recipe.id : ''), {
            method: (recipe.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(recipe)
        });
        this.props.history.goBack();
    }

    render() {
        const {recipe, selectedRecipeTypeOptions} = this.state;
        const title = <h1>{recipe.id ? 'Edit Recipe' : 'New Recipe'}</h1>;
        return (
            <div>
                <AppNavbar />
                <Container>
                    {title}
                    <Form onSubmit={this.handleSubmit}>
                        <FormGroup>
                            <Label for="inputName">Name</Label>
                            <Input type="text" name="name" id="inputName" onChange={this.handleChange} value={recipe.name || ''}/>
                        </FormGroup>
                        <FormGroup row>
                            <Col sm={4}>
                                <Label for="typeSelect">Recipe Type</Label>
                                <MultiSelect name="recipeTypes" id="typeSelect" onChange={this.handleMultiSelectChange} options={this.recipeTypeOptions} value={selectedRecipeTypeOptions}/>
                            </Col>
                        </FormGroup>
                        <FormGroup>
                            <Label for="inputIngredients">Ingredients</Label>
                            <Input type="textarea" name="ingredients" id="inputIngredients" onChange={this.handleChange} value={recipe.ingredients || ''}/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="inputInstructions">Instructions</Label>
                            <Input type="textarea" name="instructions" id="inputInstructions" onChange={this.handleChange} value={recipe.instructions || ''}/>
                        </FormGroup>
                        <FormGroup>
                            <Button color="primary" className="saveButton" type="submit">Save</Button>
                            <Button color="secondary" onClick={() => this.props.history.goBack()} className="cancelButton">Cancel</Button>
                            <Button color="danger" className="deleteButton" onClick={this.handleDelete}>Delete</Button>
                        </FormGroup>
                    </Form>
                </Container>
            </div>
        );
    }
}

export default withRouter(RecipeForm);