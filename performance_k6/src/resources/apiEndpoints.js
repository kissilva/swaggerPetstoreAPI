module.exports = {
  base_url: "http://swagger-petstore:8080/api/v3/",

  update_pet: {
    name: "Update Pet",
    endpoint: "pet",
    method: "PUT",
    body: {
      id: 100,
      name: "UpdatedDog",
      status: "sold"
    },
    params: {
      headers: { "Content-Type": "application/json" }
    }
  },

  add_pet: {
    name: "Add Pet",
    endpoint: "pet",
    method: "POST",
    body: {
      id: 100,
      name: "NewPet",
      category: { id: 1, name: "Dogs" },
      photoUrls: ["https://example.com/dog.jpg"],
      tags: [{ id: 1, name: "cute" }],
      status: "available"
    },
    params: {
      headers: { "Content-Type": "application/json" }
    }
  },

  find_pets_by_status: {
    name: "Find Pets by Status",
    endpoint: "pet/findByStatus?status=available",
    method: "GET"
  },

  find_pet_by_id: {
    name: "Find Pet by ID",
    endpoint: "pet/10",
    method: "GET"
  },

  get_inventory: {
    name: "Get Inventory",
    endpoint: "store/inventory",
    method: "GET"
  },

  place_order: {
    name: "Place Order",
    endpoint: "store/order",
    method: "POST",
    body: {
      id: 1,
      petId: 10,
      quantity: 2,
      shipDate: "2024-03-10T10:00:00.000Z",
      status: "placed",
      complete: true
    },
    params: {
      headers: { "Content-Type": "application/json" }
    }
  },

  create_user: {
    name: "Create User",
    endpoint: "user",
    method: "POST",
    body: {
      id: 1,
      username: "testuser",
      firstName: "Test",
      lastName: "User",
      email: "testuser@example.com",
      password: "securepass",
      phone: "123456789",
      userStatus: 1
    },
    params: {
      headers: { "Content-Type": "application/json" }
    }
  },

  login_user: {
    name: "Login User",
    endpoint: "user/login?username=testuser&password=securepass",
    method: "GET"
  }
};
