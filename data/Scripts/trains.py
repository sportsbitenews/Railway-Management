from bs4 import BeautifulSoup
import requests

s = 'http://www.railpnrapi.com/hauth/train_list/'
alphabets = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
with open('trains.txt', 'w') as f:
    for alphabet in alphabets:
        url = s + alphabet
        r = requests.get(url)
        html = r.text
        soup = BeautifulSoup(html, 'html.parser')
        for section in soup.find_all(id="content"):
            for row in section.find('table').find_all('tr')[1:]:
                columns = row.find_all('td')
                f.write(columns[1].get_text() + " " + columns[0].get_text() + " " + columns[0].find('a').get('href') +
                        "\n")
