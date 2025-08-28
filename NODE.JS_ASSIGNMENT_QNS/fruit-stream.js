const fs = require('fs');
const path = require('path');

// Step 1: Create a Writable Stream to write fruit data
const fruits = [
  { id: 1, name: "Apple", color: "Red", price: 120 },
  { id: 2, name: "Banana", color: "Yellow", price: 40 },
  { id: 3, name: "Mango", color: "Orange", price: 150 }
];

const fruitsFile = path.join(__dirname, 'fruits.txt');
const writableStream = fs.createWriteStream(fruitsFile);

fruits.forEach(fruit => {
  writableStream.write(JSON.stringify(fruit) + '\n');
});

writableStream.end(() => {
  console.log("Data written to fruits.txt successfully.");

  // Step 2: Read the content of fruits.txt using a readable stream
  console.log("Reading fruits.txt using stream...");
  const readableStream = fs.createReadStream(fruitsFile, { encoding: 'utf8' });

  let leftover = '';

  readableStream.on('data', chunk => {
    const lines = (leftover + chunk).split('\n');
    leftover = lines.pop(); // save incomplete line

    lines.forEach(line => {
      if (line.trim()) {
        try {
          const fruit = JSON.parse(line);
          console.log(`Fruit ID: ${fruit.id}, Name: ${fruit.name}, Color: ${fruit.color}, Price: ${fruit.price}`);
        } catch (err) {
          console.error("Error parsing line:", line);
        }
      }
    });
  });

  readableStream.on('end', () => {
    if (leftover.trim()) {
      try {
        const fruit = JSON.parse(leftover);
        console.log(`Fruit ID: ${fruit.id}, Name: ${fruit.name}, Color: ${fruit.color}, Price: ${fruit.price}`);
      } catch (err) {
        console.error("Error parsing leftover line:", leftover);
      }
    }

    // Step 3: Pipe Streams to copy content
    const fruitsCopyFile = path.join(__dirname, 'fruits_copy.txt');
    const readStream = fs.createReadStream(fruitsFile);
    const writeStream = fs.createWriteStream(fruitsCopyFile);

    readStream.pipe(writeStream);

    writeStream.on('finish', () => {
      console.log("Content copied to fruits_copy.txt using pipe.");
    });
  });

  readableStream.on('error', (err) => {
    console.error("Error reading fruits.txt:", err.message);
  });
});
