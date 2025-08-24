import React, { useEffect, useState } from 'react';
import LoadingComponent from './LoadingComponent';
import ErrorComponent from './ErrorComponent';
import ProductComponent from './ProductComponent';

const MainComponent = () => {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [product, setProduct] = useState(null);

  useEffect(() => {
    setTimeout(() => {
      const success = true; // Simulate success/failure

      success
        ? (() => {
            setProduct({
              name: 'Sony Bravia TV',
              brand: 'Sony',
              price: 65000,
              category: 'TV',
              warranty: 2,
              availability: true,
            });
            setLoading(false);
          })()
        : (() => {
            setError(true);
            setLoading(false);
          })();
    }, 2000);
  }, []);

  return (
    loading ? <LoadingComponent />
    : error ? <ErrorComponent />
    : <ProductComponent product={product} />
  );
};

export default MainComponent;
