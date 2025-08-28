const buffer = Buffer.alloc(256);

// Step 1: Create student object
const student1 = {
  id: 1,
  name: "Thananya",
  age: 20,
  grade: "A"
};

// Step 2: Write student data as string to buffer
const jsonStr1 = JSON.stringify(student1);
const bytesWritten = buffer.write(jsonStr1, 'utf8');

console.log("Bytes written to buffer:", bytesWritten);
console.log("Buffer content as string:", buffer.toString('utf8', 0, bytesWritten));

// Step 3: Read & parse student data
const parsedStr1 = buffer.toString('utf8', 0, bytesWritten);
const parsedStudent1 = JSON.parse(parsedStr1);

console.log("Parsed Student Data:");
console.log("ID:", parsedStudent1.id);
console.log("Name:", parsedStudent1.name);
console.log("Age:", parsedStudent1.age);
console.log("Grade:", parsedStudent1.grade);

// Step 4: Buffer Operations
const student2 = {
  id: 2,
  name: "Ankit",
  age: 22,
  grade: "B"
};
const jsonStr2 = JSON.stringify(student2);

// Try appending student2 if space allows
if (bytesWritten + Buffer.byteLength(jsonStr2) <= 256) {
  buffer.write(jsonStr2, bytesWritten, 'utf8');
  console.log("\nSecond student appended to buffer.");
} else {
  console.log("\nNot enough space to append second student.");
}

// Slice buffer to read only student1
const slicedBuffer = buffer.slice(0, bytesWritten);
console.log("Sliced buffer content:", slicedBuffer.toString('utf8'));

// Copy data to new buffer
const copyBuffer = Buffer.alloc(256);
slicedBuffer.copy(copyBuffer);
console.log("Copied buffer content:", copyBuffer.toString('utf8'));

// Step 5: Encoding & Decoding
const base64Encoded = buffer.toString('base64', 0, bytesWritten);
console.log("Buffer content in base64:\n" + base64Encoded);

const asciiEncoded = buffer.toString('ascii', 0, bytesWritten);
console.log("Buffer content in ascii:\n" + asciiEncoded);

const utf8Encoded = buffer.toString('utf8', 0, bytesWritten);
console.log("Buffer content in utf8:\n" + utf8Encoded);
