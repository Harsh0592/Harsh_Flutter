




import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:travel_api/Screens/thirdScreen.dart';
class SecondScreen extends StatefulWidget {
  final String cityName;

  SecondScreen({required this.cityName});

  @override
  State<SecondScreen> createState() => _SecondScreenState();
}

class _SecondScreenState extends State<SecondScreen> {
  List cities1 = [];
  void fetchdata() async {
    try {
      final response = await http.get(Uri.parse('https://harshdalsaniya.000webhostapp.com/Travel_Assesment/view_places.php'));

      if (response.statusCode == 200) {
        final List<dynamic> data = json.decode(response.body);
        
        setState(() {
          cities1 = List<String>.from(data.map((item) => item['name'].toString()));
        });
      } else {
        throw Exception('Failed to load data. Status code: ${response.statusCode}');
      }
    } catch (error) {
      print('Error: $error');
    }
  }
  
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    fetchdata();
  }
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.cityName),
      ),
      body: ListView.builder(
        itemCount: cities1.length,
        itemBuilder: (context ,int index){
        return InkWell(
          onTap: () {
            Navigator.push(context, MaterialPageRoute(builder: (BuildContext context)=>Third_Sceen(name: widget.cityName)));
          },
          child: ListTile(
            title: Text("${cities1[index]}",style: TextStyle(fontSize: 25),),
            
            leading: Icon(Icons.arrow_back_ios_new_sharp),
            // subtitle: Text("${index}"),
          ),
        );
      })
    );
  }
}


class Album{
  final int id;
      final String name;
     Album({required this.name,required this.id});
      factory Album.fromJson(Map<String,dynamic>json){
        return switch(json){
          {
            'id' : int id,
            'name':   String name,
          }=>Album(name: name, id: id), _ => throw const FormatException('Failed to load album')
        };
     }
  }