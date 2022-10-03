from urllib import response
import requests

params = {
    "word": "abcdef",
    "size": 0
}

response = requests.post("http://localhost:8080/Laboratory1_war_exploded/permutations", params)

print (response.status_code)
print (response.text)