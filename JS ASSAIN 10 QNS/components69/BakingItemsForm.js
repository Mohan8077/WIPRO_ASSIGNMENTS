// Import React and useState hook
import React, { useState } from 'react';
// Import Bootstrap CSS
import 'bootstrap/dist/css/bootstrap.min.css';

// Functional component
function BakingItemsForm() {
  // State for form inputs (all fields grouped in an object)
  const [formData, setFormData] = useState({
    itemName: '',       // Name of baking item
    quantity: '',       // Quantity
    ingredients: '',    // Ingredients
    bakingTime: '',     // Baking time in minutes
    category: 'Cake'    // Default category selection
  });

  // State for storing submitted items list
  const [items, setItems] = useState([]);

  // Handle input changes dynamically
  const handleChange = (e) => {
    const { name, value } = e.target;
    // Update the matching key in formData
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  // On form submit
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent page reload
    setItems(prev => [...prev, formData]); // Add new item to items list
    // Reset form fields to initial state
    setFormData({
      itemName: '',
      quantity: '',
      ingredients: '',
      bakingTime: '',
      category: 'Cake'
    });
  };

  return (
    <div className="container my-4">
      {/* Card container */}
      <div className="card p-4">
        <h2 className="mb-4">🧁 Baking Items Form</h2>

        {/* Form begins */}
        <form onSubmit={handleSubmit}>
          {/* Item Name input */}
          <div className="mb-3">
            <label>Item Name</label>
            <input
              type="text"
              name="itemName"
              value={formData.itemName}
              onChange={handleChange}
              className="form-control"
            />
          </div>

          {/* Quantity input */}
          <div className="mb-3">
            <label>Quantity</label>
            <input
              type="number"
              name="quantity"
              value={formData.quantity}
              onChange={handleChange}
              className="form-control"
            />
          </div>

          {/* Ingredients textarea */}
          <div className="mb-3">
            <label>Ingredients</label>
            <textarea
              name="ingredients"
              value={formData.ingredients}
              onChange={handleChange}
              className="form-control"
            ></textarea>
          </div>

          {/* Baking Time input */}
          <div className="mb-3">
            <label>Baking Time (minutes)</label>
            <input
              type="text"
              name="bakingTime"
              value={formData.bakingTime}
              onChange={handleChange}
              className="form-control"
            />
          </div>

          {/* Category dropdown */}
          <div className="mb-3">
            <label>Category</label>
            <select
              name="category"
              value={formData.category}
              onChange={handleChange}
              className="form-control"
            >
              <option>Cake</option>
              <option>Bread</option>
              <option>Pastry</option>
            </select>
          </div>

          {/* Submit button */}
          <button className="btn btn-success">Add Baking Item</button>
        </form>
      </div>

      {/* Display list of submitted items */}
      <h3 className="mt-4">Baking Items List</h3>
      <table className="table table-bordered mt-2">
        <thead className="table-dark">
          <tr>
            <th>#</th>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Ingredients</th>
            <th>Baking Time</th>
            <th>Category</th>
          </tr>
        </thead>
        <tbody>
          {/* Map through items and display each row */}
          {items.map((item, idx) => (
            <tr key={idx}>
              <td>{idx + 1}</td>
              <td>{item.itemName}</td>
              <td>{item.quantity}</td>
              <td>{item.ingredients}</td>
              <td>{item.bakingTime}</td>
              <td>{item.category}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

// Export component so it can be imported in App.js
export default BakingItemsForm;
