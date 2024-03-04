import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:travel_api/Screens/Second_Screen.dart';

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<String> cities = [];
  List<String> citesimg = [
    "https://harshdalsaniya.000webhostapp.com/Travel_Assesment/images/download%20(1).jpeg",
    "https://harshdalsaniya.000webhostapp.com/Travel_Assesment/images/download%20(5).jpeg",
    "https://harshdalsaniya.000webhostapp.com/Travel_Assesment/images/download%20(4).jpeg",
    "https://harshdalsaniya.000webhostapp.com/Travel_Assesment/images/download%20(3).jpeg",
    "https://harshdalsaniya.000webhostapp.com/Travel_Assesment/images/download%20(2).jpeg",
    "https://harshdalsaniya.000webhostapp.com/Travel_Assesment/images/download.jpeg"
  ];

  @override
  void initState() {
    super.initState();
    fetchData();
  }

  Future<void> fetchData() async {
    try {
      final response = await http.get(Uri.parse('https://harshdalsaniya.000webhostapp.com/Travel_Assesment/view_city.php'));

      if (response.statusCode == 200) {
        final List<dynamic> data = json.decode(response.body);

        setState(() {
          cities = List<String>.from(data.map((item) => item['name'].toString()));
        });
      } else {
        throw Exception('Failed to load data. Status code: ${response.statusCode}');
      }
    } catch (error) {
      print('Error: $error');
    }
  }

  @override
  Widget build(BuildContext context) {
    // Set the pixel density (device pixel ratio)
    // You can replace 2.0 with the desired pixel density
    var pixelRatio = 2.0;

    return Scaffold(
      appBar: AppBar(
        title: Text('City List'),
      ),
      body: cities.isEmpty
          ? Center(
              child: CircularProgressIndicator(),
            )
          : MediaQuery(
              data: MediaQuery.of(context).copyWith(devicePixelRatio: pixelRatio),
              child: GridView.builder(
                itemCount: cities.length,
                gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3),
                itemBuilder: (context, int index) {
                  return Card(
                    child: InkWell(
                      onTap: () {
                        Navigator.push(context, MaterialPageRoute(builder: (BuildContext context)=>SecondScreen(cityName: cities[index])));
                      },
                      child: Column(
                        children: [
                          Container(
                            child: Image.network(
                              citesimg[index],
                              height: 100,
                              width: 105,
                              fit: BoxFit.cover,
                            ),
                          ),
                          Container(
                            child: Center(
                              child: Text(
                                cities[index],
                                key: Key(cities[index]),
                              ),
                            ),
                          )
                        ],
                      ),
                    ),
                  );
                },
              ),
            ),
    );
  }
}



/*

ListView.builder(
              itemCount: cities.length,
              itemBuilder: (context, index) {
                return ListTile(
                  title: Text(cities[index]),
                );
              },
            ),

 */