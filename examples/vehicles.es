{
  "rules": [
    {
      "name": "Motorcycle",
      "antecedents": [
        {
          "varName": "motor",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "num_wheels",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 2.0
        },
        {
          "varName": "vehiculeType",
          "type": "STRING",
          "operation": "EQ",
          "value": "cycle"
        }
      ],
      "consequences": [
        {
          "varName": "vehicle",
          "type": "STRING",
          "operation": "EQ",
          "value": "Motorcycle"
        }
      ]
    },
    {
      "name": "Cycle",
      "antecedents": [
        {
          "varName": "num_wheels",
          "type": "NUMBER",
          "operation": "LESS",
          "value": 4.0
        }
      ],
      "consequences": [
        {
          "varName": "vehicleType",
          "type": "STRING",
          "operation": "EQ",
          "value": "cycle"
        }
      ]
    },
    {
      "name": "Automobile",
      "antecedents": [
        {
          "varName": "num_wheels",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 4.0
        },
        {
          "varName": "motor",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "vehicleType",
          "type": "STRING",
          "operation": "EQ",
          "value": "automobile"
        }
      ]
    },
    {
      "name": "Bicycle",
      "antecedents": [
        {
          "varName": "vehicleType",
          "type": "STRING",
          "operation": "EQ",
          "value": "cycle"
        },
        {
          "varName": "motor",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        },
        {
          "varName": "num_wheels",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 2.0
        }
      ],
      "consequences": [
        {
          "varName": "vehicle",
          "type": "STRING",
          "operation": "EQ",
          "value": "Bicycle"
        }
      ]
    },
    {
      "name": "Sedan",
      "antecedents": [
        {
          "varName": "size",
          "type": "STRING",
          "operation": "EQ",
          "value": "medium"
        },
        {
          "varName": "vehicleType",
          "type": "STRING",
          "operation": "EQ",
          "value": "automobile"
        },
        {
          "varName": "num_doors",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 4.0
        }
      ],
      "consequences": [
        {
          "varName": "vehicle",
          "type": "STRING",
          "operation": "EQ",
          "value": "Sedan"
        }
      ]
    },
    {
      "name": "Tricycle",
      "antecedents": [
        {
          "varName": "motor",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        },
        {
          "varName": "vehicleType",
          "type": "STRING",
          "operation": "EQ",
          "value": "cycle"
        },
        {
          "varName": "num_wheels",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 3.0
        }
      ],
      "consequences": [
        {
          "varName": "vehicle",
          "type": "STRING",
          "operation": "EQ",
          "value": "Tricycle"
        }
      ]
    },
    {
      "name": "MiniVan",
      "antecedents": [
        {
          "varName": "size",
          "type": "STRING",
          "operation": "EQ",
          "value": "medium"
        },
        {
          "varName": "num_doors",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 3.0
        },
        {
          "varName": "vehicleType",
          "type": "STRING",
          "operation": "EQ",
          "value": "automobile"
        }
      ],
      "consequences": [
        {
          "varName": "vehicle",
          "type": "STRING",
          "operation": "EQ",
          "value": "MiniVan"
        }
      ]
    },
    {
      "name": "SportsCar",
      "antecedents": [
        {
          "varName": "size",
          "type": "STRING",
          "operation": "EQ",
          "value": "small"
        },
        {
          "varName": "vehicleType",
          "type": "STRING",
          "operation": "EQ",
          "value": "automobile"
        },
        {
          "varName": "num_doors",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 2.0
        }
      ],
      "consequences": [
        {
          "varName": "vehicle",
          "type": "STRING",
          "operation": "EQ",
          "value": "Sports_Car"
        }
      ]
    },
    {
      "name": "SUV",
      "antecedents": [
        {
          "varName": "num_doors",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 4.0
        },
        {
          "varName": "size",
          "type": "STRING",
          "operation": "EQ",
          "value": "large"
        },
        {
          "varName": "vehicleType",
          "type": "STRING",
          "operation": "EQ",
          "value": "automobile"
        }
      ],
      "consequences": [
        {
          "varName": "vehicle",
          "type": "STRING",
          "operation": "EQ",
          "value": "Sports_Utility_Vehicle"
        }
      ]
    }
  ],
  "knowledgeBase": []
}