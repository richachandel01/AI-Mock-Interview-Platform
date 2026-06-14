function Navbar() {
  return (
    <nav className="bg-slate-900 text-white px-8 py-4 flex justify-between items-center">
      <h1 className="text-2xl font-bold">
        AI Mock Interview
      </h1>

      <div className="flex gap-6">
        <a href="/">Home</a>
        <a href="/login">Login</a>
        <a href="/signup">Signup</a>
      </div>
    </nav>
  );
}

export default Navbar;