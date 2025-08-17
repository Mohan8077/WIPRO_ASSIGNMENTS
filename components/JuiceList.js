import React from 'react';
import Juice from './Juice';

const JuiceList = () => {
  const juices = [
    { id: 1, name: 'Orange Juice', price: 80 },
    { id: 2, name: 'Apple Juice', price: 100 },
    { id: 3, name: 'Mango Juice', price: 120 },
  ];

  return (
    <div style={{ margin: '20px', display: 'flex', justifyContent: 'center' }}>
      <div>
        <h2 style={{ textAlign: 'center' }}>🥤 Juice Menu</h2>
            <table border="1" cellPadding="10" cellSpacing="0" style={{ width: '100%', borderCollapse: 'collapse' }}>
                <thead>
                    <tr>
                    <th>ID</th>
                    <th>Juice Name</th>
                    <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {juices.map((juice) => (
                    <Juice key={juice.id} id={juice.id} name={juice.name} price={juice.price} />
                        ))}
                </tbody>
            </table>
        </div>
        </div>
  );
};

export default JuiceList;
