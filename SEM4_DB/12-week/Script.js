use LogisticsDB //database

use shipments //collection


//Seeding
db.shipments.insertMany(
  Array.from({ length: 10000 }).map((_, i) => ({
    shippingWeight: Math.floor(Math.random() * 500) + 1,
    status: ["Delivered", "Pending", "In-Transit"][i % 3],
    destination: ["Dubai", "Abu Dhabi", "Sharjah", "Fujairah", "Ras Al Khaimah"][Math.floor(Math.random() * 5)]
  }))
);


// Optimization
db.shipments.find({ status: "Pending" }).explain("executionStats");
db.shipments.createIndex({ status: 1 });
db.shipments.find({ status: "Pending" }).explain("executionStats");

//Analytics
db.shipments.aggregate([
  {
    $group: {
      _id: "$status",
      count: { $sum: 1 }
    }
  }
]);
