const express = require('express');
const app = express();
const port = 8080;

app.get('/', (req, res) => {
    res.send('Hello from Express')
})

app.use(express.static(__dirname + '/html'));
//app.use('/html', express.static(__dirname + '/html'));

app.listen(port, () => {
    console.log(`Server is listening on ${port}`)
})