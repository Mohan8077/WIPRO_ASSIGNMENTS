import React from 'react';

const ServiceCard = ({ service }) => {
  return (
    <div className="col-md-4 mb-4">
      <div className="card h-100">
        <div className="card-body">
          <h5 className="card-title">{service.serviceName}</h5>
          <p className="card-text">
            <strong>Price:</strong> ₹{service.price}
          </p>
          <p className="card-text">
            <strong>Fabrics:</strong>
            <ul>
              {service.fabricsAvailable.map((fabric, index) => (
                <li key={index}>{fabric}</li>
              ))}
            </ul>
          </p>
        </div>
      </div>
    </div>
  );
};

export default ServiceCard;
