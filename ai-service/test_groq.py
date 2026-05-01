import os
import requests
from dotenv import load_dotenv

load_dotenv()

GROQ_API_KEY = os.getenv("GROQ_API_KEY")
if not GROQ_API_KEY:
    raise SystemExit("Set GROQ_API_KEY in .env before running this script.")

GROQ_API_URL = "https://api.groq.com/v1/models"
HEADERS = {
    "Authorization": f"Bearer {GROQ_API_KEY}",
    "Content-Type": "application/json",
}

def fetch_models():
    response = requests.get(GROQ_API_URL, headers=HEADERS, timeout=10)
    response.raise_for_status()
    return response.json()

if __name__ == "__main__":
    print("Starting Groq API test call...")
    models = fetch_models()
    print("Groq API call succeeded. Response:")
    print(models)
