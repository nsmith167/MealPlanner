import React, { Component } from 'react';
import './App.scss';
import './RecipeForm.scss';
import AppNavbar from './AppNavbar';
import {Link, withRouter } from 'react-router-dom';
import { Container, Button } from 'reactstrap'

class RecipeView extends Component {
    emptyRecipe = {
        name: '',
        recipeType: '',
        instructions: '',
        ingredients: '',
    };

    recipeTypeMap = {
        BREAKFAST: "Breakfast",
        AM_SNACK: "AM Snack",
        LUNCH: "Lunch",
        PM_SNACK: "PM Snack",
        DINNER: "Dinner",
        NIGHT_SNACK: "Night Snack"
    }

    constructor(props) {
        super(props);
        this.state = {
            recipe: this.emptyRecipe
        };
        this.handleDelete = this.handleDelete.bind(this);
    }

    async componentDidMount() {
        const returnedRecipe = await (await fetch(`/recipes/recipe/${this.props.match.params.id}`)).json();
        this.setState({recipe: returnedRecipe});
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

    render() {
        const {recipe} = this.state;
        return (
            <div>
                <AppNavbar />
                <Container>
                    <div class="recipe-header">
                        <h1>{recipe.name || 'Unnamed recipe'}</h1>
                        <h4 class="text-muted">{this.recipeTypeMap[recipe.recipeType]}</h4>
                    </div>
                    <div class="recipe-view-row">
                        <h3>Ingredients</h3>
                        <ListElement content={recipe.ingredients} ordered={false} />
                    </div>
                    <div class="recipe-view-row">
                        <h3>Instructions</h3>
                        <ListElement content={recipe.instructions} ordered={true} />
                    </div>             
                    <div class="recipe-view-row">
                        <Button color="primary" tag={Link} to={'/recipe-form/' + recipe.id}>Edit</Button>
                        <Button color="secondary" onClick={() => this.props.history.goBack()} className="cancelButton">Cancel</Button>
                        <Button color="danger" className="deleteButton" onClick={this.handleDelete}>Delete</Button>
                    </div>
                </Container>
            </div>
        );
    }
}

const ListElement = props => {
    const splitContent = props.content.split("\n"); 
    const listItems = splitContent.map(item => {return <li>{item}</li>});
    if (props.ordered) {
        return (<ol>{listItems}</ol>);
    } else {
        return (<ul>{listItems}</ul>);
    }
}

export default withRouter(RecipeView);