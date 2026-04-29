use University

use Student

db.Student.insertOne({
  name: "Priyanshu",
  age: 20,
  course: "CSE",
  year: 2
})


db.Student.insertMany([
  { name: "Nikhil", age: 20, course: "CSE", year: 2 },
  { name: "Sam", age: 21, course: "ME", year: 3 },
  { name: "Pratham", age: 19, course: "CSE", year: 1 }
])




db.Student.findOne({ name: "Priyanshu" })


db.Student.find({ course: "CSE" }).pretty()




db.Student.updateOne(
  { name: "Sam" }, 
  { $set: { course: "CSE" } } 
)


db.Student.updateMany(
  { course: "CSE" }, 
  { $inc: { year: 1 } } 
)



db.Student.deleteOne({ name: "Nikhil" })


db.Student.deleteMany({ year: 4 })
