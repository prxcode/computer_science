use LogisticsDB //database

use shipments //collection


//Seeding
db.shipments.insertMany(
  Array.from({ length: 10000 }).map((_, i) => ({ // array from creates empty container for data, while map function iterates every one of those 10k slots and transform into document
    shippingWeight: Math.floor(Math.random() * 500) + 1,
    status: ["Delivered", "Pending", "In-Transit"][i % 3],
    destination: ["Dubai", "Abu Dhabi", "Sharjah", "Fujairah", "Ras Al Khaimah"][Math.floor(Math.random() * 5)]
  }))
);


// Optimization: database performs COLLSCAN collection scan it reads every single line of 10K documents
db.shipments.find({ status: "Pending" }).explain("executionStats");
db.shipments.createIndex({ status: 1 }); // creates a sorted map of status field
db.shipments.find({ status: "Pending" }).explain("executionStats"); // shows improvments iwth index performs IXSCAN Index Scan jumping directly into pending records without reading entire collection.

//Analytics via aggregation transforming raw data into high lev businness intelligence
db.shipments.aggregate([ 
  {
    $group: { // group stage acts like filter sorts all 10k documents into buckets based on status
      _id: "$status",
      count: { $sum: 1 } // for every doc which falls into this, it adds 1 to counter 
    }
  }
]);


// example output: { "_id": "Delivered", "count": 3334 }
