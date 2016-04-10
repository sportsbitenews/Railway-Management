from bs4 import BeautifulSoup
import requests

with open('stations.txt', 'w') as f:
    url  = 'http://www.railpnrapi.com/hauth/station_list'
    r = requests.get(url)
    html = r.text
    soup = BeautifulSoup(html, 'html.parser')
    for row in soup.find('table').find_all('tr')[1:]:
        columns = row.find_all('td')
        f.write(columns[0].get_text() + " " + columns[1].get_text() + "\n")
