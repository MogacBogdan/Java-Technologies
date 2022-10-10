from urllib import response
import requests
import asyncio

params = {
    "word": "abcdef",
    "size": 0,
    "category": "default"
}

async def create_post_request():
    for i in range (50):
        response = requests.post("http://localhost:8080/Laboratory1_war_exploded/permutations", params)
        print (response.status_code)
        print (response.text)
    return 0



loop = asyncio.get_event_loop()
loop.run_until_complete(create_post_request())
loop.close()
print ("FINISH")