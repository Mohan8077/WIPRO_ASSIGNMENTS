import React, { Component } from 'react';

// Functional Component: receives "fruits" as props and displays them
function FruitList({ fruits }) {
  return (
    <div>
      {/* Heading for the fruit list */}
      <h3>Fruits List</h3>

      {/* Unordered list to show fruits */}
      <ul>
        {/* Loop through the "fruits" array using map */}
        {fruits.map((fruit, index) => (
          // Each item needs a unique key; here index is used
          <li key={index}>{fruit}</li>
        ))}
      </ul>
    </div>
  );
}

// Class Component: manages the fruit list and input for adding new fruit
class Fruits extends Component {
  constructor(props) {
    super(props); // Call parent (Component) constructor
    // Initialize component state
    this.state = {
      fruits: ['Apple', 'Banana', 'orange'], // Default fruits list
      newFruit: '' // Stores the input text value
    };
  }

  // Event handler for input change, updates "newFruit" in state
  handleChange = (event) => {
    this.setState({ newFruit: event.target.value });
  };

  // Adds a new fruit to the list if input is not empty
  addFruit = () => {
    const { newFruit, fruits } = this.state; // Destructure state
    if (newFruit.trim() !== '') { // Check input not blank
      this.setState({
        fruits: [...fruits, newFruit.trim()], // Spread existing fruits + new one
        newFruit: '' // Reset input field
      });
    }
  };

  // Renders the UI
  render() {
    return (
      // Inline styling for padding and font
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        {/* Title */}
        <h2>Fruits</h2>

        {/* Input box bound to state.newFruit */}
        <input
          type="text"
          value={this.state.newFruit}
          onChange={this.handleChange} // Update on typing
        />

        {/* Button calls addFruit on click */}
        <button onClick={this.addFruit}>Add</button>

        {/* Pass current fruit list to FruitList component */}
        <FruitList fruits={this.state.fruits} />
      </div>
    );
  }
}

export default Fruits;
