const http = require("http");
const fs = require("fs");

const server = http.createServer((req, res) => {
  if (req.url.includes("style.css")) {
    fs.readFile("style.css", "utf-8", (err, html) => {
      if (err) {
        console.log(err);
      } else {
        res.writeHead(200, { "Content-Type": "text/css" });
        res.end(html);
      }
    });
  } else if (req.url.includes("index.js")) {
    fs.readFile("index.js", "utf-8", (err, html) => {
      if (err) {
        console.log(err);
      } else {
        res.writeHead(200, { "Content-Type": "text/javascript" });
        res.end(html);
      }
    });
  } else if (req.url.includes("categories.html")) {
    fs.readFile("categories.html", "utf-8", (err, html) => {
      if (err) {
        console.log(err);
      } else {
        res.writeHead(200, { "Content-Type": "text/html" });
        res.end(html);
      }
    });
  } else if (req.url.includes("dishes.html")) {
    fs.readFile("dishes.html", "utf-8", (err, html) => {
      if (err) {
        console.log(err);
      } else {
        res.writeHead(200, { "Content-Type": "text/html" });
        res.end(html);
      }
    });
  } else {
    fs.readFile("categories.html", "utf-8", (err, html) => {
      if (err) {
        console.log(err);
      } else {
        res.writeHead(200, { "Content-Type": "text/html" });
        res.end(html);
      }
    });
  }
});

server.listen(8000, () => console.log("Up"));
