// Import React and Component
import React, { Component } from 'react';
// Import Bootstrap CSS for styling
import 'bootstrap/dist/css/bootstrap.min.css';

// Class component for handling accessories form
class AccessoriesForm extends Component {
  constructor(props) {
    super(props); // Call parent constructor
    // Initialize state values
    this.state = {
      name: '',          // Accessory name
      description: '',   // Accessory description
      category: 'Electronics', // Default dropdown value
      brand: '',         // Selected brand (radio buttons)
      inStock: false,    // Checkbox for stock availability
      warranty: 0,       // Warranty years (number input)
      submitted: false   // Track if form submitted
    };
  }

  // Generic handler: works for text, textarea, select, checkbox, and radio
  handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    // If checkbox, use checked property, else use value
    this.setState({
      [name]: type === 'checkbox' ? checked : value
    });
  };

  // On submit, prevent reload and set submitted flag
  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({ submitted: true });
  };

  // Render UI
  render() {
    // Destructure state for easy use
    const { name, description, category, brand, inStock, warranty, submitted } = this.state;

    return (
      <div className="container my-4">
        {/* Card containing the form */}
        <div className="card p-4">
          <h2 className="text-center mb-4">🧰 Accessories Form</h2>

          {/* Form begins */}
          <form onSubmit={this.handleSubmit}>
            {/* Accessory Name input */}
            <div className="mb-3">
              <label>Accessory Name</label>
              <input
                type="text"
                className="form-control"
                name="name"
                value={name}
                onChange={this.handleChange}
              />
            </div>

            {/* Description textarea */}
            <div className="mb-3">
              <label>Description</label>
              <textarea
                className="form-control"
                name="description"
                value={description}
                onChange={this.handleChange}
              ></textarea>
            </div>

            {/* Category dropdown */}
            <div className="mb-3">
              <label>Category</label>
              <select
                className="form-control"
                name="category"
                value={category}
                onChange={this.handleChange}
              >
                <option>Electronics</option>
                <option>Furniture</option>
                <option>Kitchen</option>
              </select>
            </div>

            {/* Brand radio buttons */}
            <div className="mb-3">
              <label>Brand</label>
              <div>
                <input
                  type="radio"
                  name="brand"
                  value="Sony"
                  onChange={this.handleChange}
                /> Sony
                <input
                  type="radio"
                  name="brand"
                  value="Samsung"
                  className="ms-3"
                  onChange={this.handleChange}
                /> Samsung
                <input
                  type="radio"
                  name="brand"
                  value="LG"
                  className="ms-3"
                  onChange={this.handleChange}
                /> LG
              </div>
            </div>

            {/* Stock availability checkbox */}
            <div className="mb-3 form-check">
              <input
                type="checkbox"
                className="form-check-input"
                name="inStock"
                checked={inStock}
                onChange={this.handleChange}
              />
              <label className="form-check-label">Available in stock</label>
            </div>

            {/* Warranty number input */}
            <div className="mb-3">
              <label>Warranty (Years)</label>
              <input
                type="number"
                className="form-control"
                name="warranty"
                value={warranty}
                onChange={this.handleChange}
              />
            </div>

            {/* Submit button */}
            <button className="btn btn-success">Submit</button>
          </form>
        </div>

        {/* Display submitted details in table format */}
        {submitted && (
          <div className="card mt-4 p-4">
            <h3>Submitted Accessory</h3>
            <table className="table table-bordered mt-3">
              <tbody>
                <tr><th>Name</th><td>{name}</td></tr>
                <tr><th>Description</th><td>{description}</td></tr>
                <tr><th>Category</th><td>{category}</td></tr>
                <tr><th>Brand</th><td>{brand}</td></tr>
                <tr><th>In Stock</th><td>{inStock ? 'Yes' : 'No'}</td></tr>
                <tr><th>Warranty</th><td>{warranty} Year(s)</td></tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

// Export component
export default AccessoriesForm;
