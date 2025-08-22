// Import React and Component class
import React, { Component } from 'react';

// Functional Component: accepts "models" as props and displays them in a list
function TelevisionList({ models }) {
  return (
    <div>
      {/* Heading for TV list */}
      <h3>Television List</h3>

      {/* Display each TV model as list item */}
      <ul>
        {models.map((model, index) => (
          // Use index as key (not ideal in real apps but works here)
          <li key={index}>{model}</li>
        ))}
      </ul>
    </div>
  );
}

// Class Component: manages state (TV models + new model input)
class TelevisionManager extends Component {
  constructor(props) {
    super(props); // Call parent (Component) constructor
    this.state = {
      models: ['Samsung QLED', 'LG OLED'], // Initial TV models list
      newModel: '' // Input box value
    };
  }

  // Handle input change: update "newModel" in state
  handleChange = (e) => {
    this.setState({ newModel: e.target.value });
  };

  // Add new model into the "models" array
  addModel = () => {
    const { newModel, models } = this.state; // Destructure state
    if (newModel.trim() !== '') { // Prevent empty input
      this.setState({
        models: [...models, newModel.trim()], // Append new model
        newModel: '' // Reset input field
      });
    }
  };

  // Render method defines UI
  render() {
    return (
      <div style={{ padding: '20px' }}>
        {/* Page heading */}
        <h2>Television Manager</h2>

        {/* Input bound to newModel value */}
        <input
          type="text"
          value={this.state.newModel}
          onChange={this.handleChange} // Update state on typing
          placeholder="Enter TV model" // Hint text in input
        />

        {/* Button to trigger addModel */}
        <button onClick={this.addModel}>Add Model</button>

        {/* Child component displays the updated list */}
        <TelevisionList models={this.state.models} />
      </div>
    );
  }
}

// Export class so it can be imported into App.js or elsewhere
export default TelevisionManager;
