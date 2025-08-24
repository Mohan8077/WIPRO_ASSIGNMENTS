import React, { useState } from 'react';

const FurnitureStore = () => {
  const [selectedFurniture, setSelectedFurniture] = useState('Chair');

  const renderFurniture = (type) => {
    switch (type) {
      case 'Chair':
        return <Chair />;
      case 'Table':
        return <Table />;
      case 'Sofa':
        return <Sofa />;
      case 'Bed':
        return <Bed />;
      default:
        return <p>Select a furniture type.</p>;
    }
  };

  return (
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',     // center horizontally
        justifyContent: 'center', // center vertically
        minHeight: '100vh',       // full viewport height
        padding: '20px',
        boxSizing: 'border-box',
        textAlign: 'center',
      }}
    >
      <h1>Furniture Store</h1>
      <select
        value={selectedFurniture}
        onChange={(e) => setSelectedFurniture(e.target.value)}
        style={{ marginBottom: '20px' }}
      >
        <option value="Chair">Chair</option>
        <option value="Table">Table</option>
        <option value="Sofa">Sofa</option>
        <option value="Bed">Bed</option>
      </select>

      {renderFurniture(selectedFurniture)}
    </div>
  );
};

// =========================
// Sub-components below
// =========================

const Chair = () => {
  const data = {
    name: 'Office Chair',
    price: 2500,
    material: 'Plastic',
    brand: 'Nilkamal',
  };

  return (
    <Card title="🪑 Chair">
      <Info data={data} />
    </Card>
  );
};

const Table = () => {
  const data = {
    name: 'Dining Table',
    price: 7500,
    material: 'Wood',
    size: '6 Seater',
    brand: 'Godrej',
  };

  return (
    <Card title="🪑 Table">
      <Info data={data} />
    </Card>
  );
};

const Sofa = () => {
  const data = {
    name: 'Recliner Sofa',
    price: 15000,
    material: 'Leather',
    size: '3 Seater',
    brand: 'Urban Ladder',
  };

  return (
    <Card title="🛋️ Sofa">
      <Info data={data} />
    </Card>
  );
};

const Bed = () => {
  const data = {
    name: 'Queen Size Bed',
    price: 18000,
    material: 'Engineered Wood',
    size: 'Queen',
    brand: 'Wakefit',
  };

  return (
    <Card title="🛏️ Bed">
      <Info data={data} />
    </Card>
  );
};

// =========================
// Shared Components
// =========================

const Card = ({ title, children }) => (
  <div
    style={{
      marginTop: '20px',
      border: '1px solid #ccc',
      borderRadius: '8px',
      padding: '16px',
      maxWidth: '300px',
    }}
  >
    <h3>{title}</h3>
    {children}
  </div>
);

const Info = ({ data }) => (
  <div>
    <p>
      <strong>Name:</strong> {data.name}
    </p>
    <p>
      <strong>Price:</strong> ₹ {data.price}
    </p>
    <p>
      <strong>Material:</strong> {data.material}
    </p>
    {data.size && (
      <p>
        <strong>Size:</strong> {data.size}
      </p>
    )}
    <p>
      <strong>Brand:</strong> {data.brand}
    </p>
  </div>
);

export default FurnitureStore;
