@Contact
Feature: Contact

  @Scenario1
  Scenario: Careers selection
    Given I launch the website
    When I navigate to Contact page from the main menu
    Then I see the following office locations for the region AMERICAS
      | City            | Address                                                     | Phone Number    |
      | Atlanta         | 384 Northyards Blvd NW  Suite 300 Atlanta, GA 30313         | +1-770-407-3400 |
      | Austin          | 300 West Sixth Street,  Suite 1600  Austin, TX 78701        | +1-512-532-2000 |
      | Boston          | 40 Water Street  Boston, MA 02109                           | +1-617-621-0200 |
      | Boulder         | 1845 Folsom Street,  Boulder, CO 80302                      | +1-720-383-4276 |
      | Calgary         | 700 2nd Street SW,  Suite 2340  Calgary, Alberta T2P 2W1    | +1-403-444-5574 |
      | Chicago         | 35 W Wacker Drive   Chicago, IL 60601                       | +1-312-696-5000 |
      | Cleveland       | 629 Euclid Avenue,  15th Floor  Cleveland, OH 44144         | +1-216-896-8900 |
      | Dallas          | 2828 Routh Street,  Suite 200  Dallas, TX 75201             | +1-214-749-0080 |
      | Dayton          | 70 Birch Alley,  Suite 240  Beavercreek, OH 45440           | +1-937-723-2322 |
      | Denver          | 4401 South Quebec Street,  Suite 200  Denver, CO 80237      | +1-303-770-8986 |
      | Detroit         | 135 N. Old Woodward Avenue,  Birmingham, MI 48009           | +1-248-530-4030 |
      | Houston         | 1111 Bagby Street,  Suite 1950  Houston, TX 77002           | +1-713-493-6880 |
      | Irvine          | 18300 Von Karman Avenue,  Suite 700,  Irvine, CA 92612      | +1-949-404-2900 |
      | Los Angeles     | 2301 Rosecrans Avenue,  Suite 5100  El Segundo, CA 90245    | +1-310-343-6111 |
      | Miami           | 2911 Grand Avenue,  Suite 100B  Miami, FL 33133             | +1-305-253-0100 |
      | Minneapolis     | 121 N Washington Ave Minneapolis, MN 55401                  | +1-612-547-0950 |
      | New York        | 375 Hudson Street,  9th Floor  New York, NY 10014           | +1-212-798-6600 |
      | Portland        | 1330 NW 14th Avenue,  Portland, OR 97209                    | +1-503-444-3795 |
      | San Francisco   | 350 Bush Street,  Floor 17  San Francisco, CA 94104         | +1-415-369-6300 |
      | San Jose        | 1 Almaden Boulevard,  Suite 650,  San Jose, CA 95113        | +1-408-275-7117 |
      | San Luis Obispo | 4800 Morabito Place,  San Luis Obispo, CA 93401             | +1-805-781-0546 |
      | Seattle         | 424 2nd Avenue West,  Seattle, WA 98119                     | +1-206-816-8800 |
      | Toronto         | 134 Peter Street,  12th Floor  Toronto, ON M5V 2H2          | +1-416-645-1500 |
      | Washington D.C. | 1515 North Courthouse Road,  4th Floor  Arlington, VA 22201 | +1-703-908-2400 |
    Then I see the following office locations for the region APAC
      | City      | Address                                                                                                                                                                                   | Phone Number      |
      | Beijing   | Tower B-1503 & 04,  Lei Shing Hong Plaza,  No. 8 Wangjing Street,  Chaoyang District,  100102 Beijing, China                                                                              | +86-10-5982-2077  |
      | Bengaluru | Sapient Consulting Pvt. Ltd., 2870,  Building - Virgo, Bagmane Constellation Business Park, Outer Ring Road, Doddanekundi Circle,  Marathahalli Post Bengaluru – 560037  Karnataka, India | +91-080-6128-0000 |
      | Gurgaon   | Sapient Consulting Pvt. Ltd.,  Candor Techspace, Tower - A,  Building no. 2, Sector 21,  Old Delhi-Gurgaon Road,  Dundahera, Gurgaon - 122016 Haryana, India                              | +91-124-389-3128  |
      | Hong Kong | 22/F Chinachem Exchange Square,  1 Hoi Wan Street,  Quarry Bay, Hong Kong                                                                                                                 | +852-3102-4512    |
      | Jakarta   | Jl. DR. Ide Anak Agung Gde Agung,  RT.1/RW.2, RT.5/RW.2,  Kuningan, East Kuningan,  Setiabudi, South Jakarta City,  Jakarta 12950, Indonesia                                              | +62-21-5081-5501  |
      | Melbourne | Level 7, 28 Freshwater Place,  Southbank, Melbourne VIC 3006, Australia                                                                                                                  | +03-9946-3300     |
      | Mumbai    | Sapient Consulting Pvt. Ltd.,  R-Tech Park, Goregaon(E),  13th Floor, Building 2,  Off Western Express Highway,  Mumbai, Maharashtra - 400063, India                                      | +91-022-3300-0600 |
      | Noida     | Sapient Consulting Pvt. Ltd.,  Tower C, Ground Floor to 4th Floor,  IT/ ITES SEZ, Plot No. 7,  Sector -144, Noida,  Distt. G. B. Nagar (U.P.), India                                      | +91-120-479-5000  |
      | Shanghai  | 19/F, Henderson 688 Plaza,  No. 688 West Nanjing Road,  Jingan District,  Shanghai, China 200041                                                                                          | +86-21-6193-1600  |
      | Singapore | 16 Collyer Quay,  Level 4, Unit 02,  Singapore 049318                                                                                                                                     | +65-6671-4933     |
      | Sydney    | Level 6, 338 Pitt Street,  Sydney NSW 2000, Australia                                                                                                                                     | +61-2-9581-2900   |
      | Tokyo     | Publicis Sapient (a division of MMS Communications K.K.) JR Tokyu Meguro Building 12F 3-1-1 Kami-Osaki, Shinagawa-ku Tokyo 141-0021, Japan                                                | +81-3-5437-7200   |
