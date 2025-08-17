import React from 'react';

const SweetsList = () => {
  // Array of sweets as JSON objects
  const sweets = [
    { id: 1, name: 'Laddu', price: 50 },
    { id: 2, name: 'Jalebi', price: 40 },
    { id: 3, name: 'Rasgulla', price: 60 },
    { id: 4, name: 'Gulab Jamun', price: 70 },
  ];

  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h2>Sweets List:</h2>
      <ul style={{ listStyleType: 'disc', paddingLeft: '20px', display: 'inline-block', textAlign: 'left' }}>
        {sweets.map(sweet => (
          <li key={sweet.id}>
            {sweet.name} - Price: ₹{sweet.price}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SweetsList;
