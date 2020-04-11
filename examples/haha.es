{
  "rules": [
    {
      "name": "Bicycle",
      "antecedents": [
        {
          "varName": "num_wheels",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 2.0
        },
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
    }
  ],
  "knowledgeBase": [
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
      "value": 2.0
    }
  ]
}