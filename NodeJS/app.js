import express from 'express'

const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.get('/data', (req, res) => {
  const date = new Date();
  const formatted_date = format(date, 'dd/MM/yyyy')
  res.send(formatted_date)
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})
