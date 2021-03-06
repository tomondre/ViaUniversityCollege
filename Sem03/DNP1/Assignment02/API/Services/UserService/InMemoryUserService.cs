using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Person;


namespace FileData
{
    public class InMemoryUserService : IUserService
    {
        private List<User> users;

        public InMemoryUserService(IAdultService adultService)
        {
            Adult administrator = new Adult()
            {
                FirstName = "Tomas",
                LastName = "Ondrejka",
                Age = 20,
                Height = 180,
                Sex = "M",
                Weight = 75,
                EyeColor = "Green",
                HairColor = "Black",
                JobTitle = new Job()
                {
                    Salary = 80000,
                    JobTitle = "Software Engineer"
                }
            };
                
            adultService.AddAdultAsync(administrator);
            User user = new User(administrator);
            user.Password = "halabala";
            user.SecurityType = "Administrator";
            user.UserName = "tomondre";
            user.Id = adultService.GetAdultsIdAsync(administrator).Result;
            
            
            Adult marketing = new Adult()
            {
                FirstName = "Peter",
                LastName = "Petersen",
                Age = 22,
                Height = 185,
                Sex = "M",
                Weight = 75,
                EyeColor = "Yellow",
                HairColor = "Red",
                JobTitle = new Job()
                {
                    Salary = 70000,
                    JobTitle = "Business Development Manager"
                }
            };
                
            adultService.AddAdultAsync(marketing);
            User market = new User(marketing);
            market.Password = "1234";
            market.SecurityType = "Marketing";
            market.UserName = "TheMarketingGuy";
            market.Id = adultService.GetAdultsIdAsync(marketing).Result;

            users = new()
            {
                user, market
            };
        }

        public async Task<User> ValidateUserAsync(string username, string password)
        {
            User user = users.First((user) => user.UserName == username && user.Password == password);
            if (user == null)
            {
                throw new Exception("Cannot validate");
            }
            return user;
        }
    }
}