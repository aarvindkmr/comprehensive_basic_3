import pytest
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service


@pytest.fixture
def driver():
    chrome_driver_path = './chromedriver-win32/chromedriver.exe'
    chrome_service = Service(executable_path=chrome_driver_path)
    driver = webdriver.Chrome(service=chrome_service)
    chrome_options = webdriver.ChromeOptions()
    chrome_options.add_argument('--acceptInsecureCerts')
    driver = webdriver.Chrome(options=chrome_options)
    yield driver
    # Close the browser after the test


def test_process_discovery_navigation(driver):
    # Navigate to the website
    driver.get("https://www.automationanywhere.com/")
    driver.maximize_window()
    cookies_btn = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.ID, "onetrust-accept-btn-handler"))
    )
    cookies_btn.click()

    # Wait for the "Products" menu to be clickable
    products_menu = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//a[@href='/products']"))
    )

    # Create an ActionChains object to perform mouse over
    action = ActionChains(driver)
    action.move_to_element(products_menu).perform()

    # Wait for the "Process Discovery" link to be clickable
    process_discovery_link = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//a[@href='/products/process-discovery']"))
    )

    # Click on "Process Discovery"
    process_discovery_link.click()

    # Wait for the page to load
    WebDriverWait(driver, 7).until(
        EC.url_to_be("https://www.automationanywhere.com/products/process-discovery")
    )

    # Verify the current URL is https://www.automationanywhere.com/products/process-discovery
    current_url = driver.current_url
    expected_url = 'https://www.automationanywhere.com/products/process-discovery'
    assert current_url == expected_url, f"Expected URL: {expected_url}, Actual URL: {current_url}"
    driver.quit()
# To run the test, execute the following command in the terminal
# pytest your_test_script_name.py
