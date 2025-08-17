import React from 'react';

const TempleList = () => {
  const temples = [
    {
      id: 1,
      name: 'Meenakshi Amman Temple',
      location: 'Madurai, Tamil Nadu',
      deities: ['Meenakshi', 'Sundareswarar'],
    },
    {
      id: 2,
      name: 'Sri Venkateswara Temple',
      location: 'Tirupati, Andhra Pradesh',
      deities: ['Venkateswara', 'Lakshmi'],
    },
    {
      id: 3,
      name: 'Jagannath Temple',
      location: 'Puri, Odisha',
      deities: ['Jagannath', 'Balabhadra', 'Subhadra'],
    },
  ];

  return (
    <div style={{ margin: '30px' }}>
      <h2>🛕 Famous Temples in India</h2>
      <table border="1" cellPadding="10" cellSpacing="0" style={{ width: '100%', borderCollapse: 'collapse' }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Temple Name</th>
            <th>Location</th>
            <th>Deities</th>
          </tr>
        </thead>
        <tbody>
          {temples.map((temple) => (
            <tr key={temple.id}>
              <td>{temple.id}</td>
              <td>{temple.name}</td>
              <td>{temple.location}</td>
              <td>
                <ul style={{ paddingLeft: '20px', margin: 0 }}>
                  {temple.deities.map((deity, index) => (
                    <li key={index}>{deity}</li>
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TempleList;
