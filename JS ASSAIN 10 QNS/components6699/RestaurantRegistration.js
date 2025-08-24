import React, { useState, useEffect } from 'react';

const RestaurantRegistration = () => {
  const [formData, setFormData] = useState({
    restaurantName: '',
    ownerName: '',
    email: '',
    contact: '',
    address: '',
    cuisine: '',
    openingHours: '',
  });

  const [submittedData, setSubmittedData] = useState(null);

  // Run on every render
  useEffect(() => {
    console.log('Component rendered');
  });

  // Run only once (on mount)
  useEffect(() => {
    alert('Welcome to Restaurant Registration 🏪');
  }, []);

  // Run whenever formData changes
  useEffect(() => {
    console.log('Form data changed:', formData);
  }, [formData]);

  // Auto-save form data every 5 seconds
  useEffect(() => {
    const interval = setInterval(() => {
      console.log('Auto-saving data...', formData);
      // You can add actual saving logic here (e.g., localStorage or API)
    }, 5000);

    // Cleanup interval on unmount or when formData changes
    return () => clearInterval(interval);
  }, [formData]);

  // Handle form inputs change
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // Handle form submit
  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmittedData(formData);
  };

  return (
    <div style={{ maxWidth: '600px', margin: '20px auto', fontFamily: 'Arial, sans-serif' }}>
      <h1>🪑 Restaurant Registration Form</h1>
      <p>Welcome to Restaurant Registration 🏪</p>

      <form onSubmit={handleSubmit}>
        <div>
          <label>Restaurant Name</label><br />
          <input type="text" name="restaurantName" value={formData.restaurantName} onChange={handleChange} required />
        </div>

        <div>
          <label>Owner Name</label><br />
          <input type="text" name="ownerName" value={formData.ownerName} onChange={handleChange} required />
        </div>

        <div>
          <label>Email</label><br />
          <input type="email" name="email" value={formData.email} onChange={handleChange} required />
        </div>

        <div>
          <label>Contact Number</label><br />
          <input type="tel" name="contact" value={formData.contact} onChange={handleChange} required />
        </div>

        <div>
          <label>Address</label><br />
          <input type="text" name="address" value={formData.address} onChange={handleChange} required />
        </div>

        <div>
          <label>Cuisine Type</label><br />
          <input type="text" name="cuisine" value={formData.cuisine} onChange={handleChange} required />
        </div>

        <div>
          <label>Opening Hours</label><br />
          <input type="text" name="openingHours" value={formData.openingHours} onChange={handleChange} required />
        </div>

        <br />
        <button type="submit">Submit</button>
      </form>

      {submittedData && (
        <>
          <h3>📄 Submitted Data (JSON)</h3>
          <pre>{JSON.stringify(submittedData, null, 2)}</pre>
        </>
      )}
    </div>
  );
};

export default RestaurantRegistration;
