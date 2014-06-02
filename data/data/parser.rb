#!/usr/bin/ruby
require 'csv'
require 'nokogiri'
require 'open-uri'

# The page which contains all the links to categories
main_page = Nokogiri::HTML(open('http://calorii.oneden.com/'))

# We get the table with the links
main_page_table = main_page.css('.tabelcalorii').first

# The iterate through each link that points to a category
main_page_table.css('td strong a').each do |link_to_category|
	# We get store the link
	link = link_to_category.attr('href')
	
	# We open each category
	category_page = Nokogiri::HTML(open(link))
	
	# Select the table
	table = category_page.css('.tabelcalorii').first
	
	# The name under which we save the CSV
	file_name = link['http://calorii.oneden.com/'.length ... -1] + '.csv'

	# Open the csv file
	CSV.open(file_name, "wb") do |csv|
		puts "Parsing #{link}"
		# Iterate through each link in the table
		table.css('tr')[1 ... -2].each do |tr|
			# Get the columns
			columns = tr.css('td')
			
			# Get each field
			name = columns[0]
			calories = columns[1]
			proteins = columns[2]
			lipids = columns[3]
			carbs = columns[4]
			fibers = columns[5]
			
			# Insert the fields into the CSV file
			csv << [name, calories, proteins, lipids, carbs, fibers]
		end
	end
end
