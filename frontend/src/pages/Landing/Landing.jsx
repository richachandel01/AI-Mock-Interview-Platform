import Navbar from "../../components/layout/Navbar";
import Footer from "../../components/layout/Footer";

function Landing() {
  return (
    <>
      <Navbar />

      {/* Hero Section */}
      <section className="min-h-screen flex flex-col justify-center items-center bg-slate-100 text-center px-6">
        <h1 className="text-5xl font-bold mb-6">
          Crack Your Dream Job With AI Mock Interviews
        </h1>

        <p className="text-lg text-gray-600 max-w-2xl">
          Practice technical interviews, receive AI-powered feedback,
          improve communication skills, and boost your confidence.
        </p>

        <button className="mt-8 bg-blue-600 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition">
          Start Interview
        </button>
      </section>

      {/* Features Section */}
      <section className="py-20 px-10">
        <h2 className="text-4xl font-bold text-center mb-12">
          Platform Features
        </h2>

        <div className="grid md:grid-cols-3 gap-8">

          <div className="shadow-lg p-6 rounded-xl">
            <h3 className="text-xl font-bold mb-3">
              AI Question Generation
            </h3>

            <p>
              Generate role-based interview questions instantly.
            </p>
          </div>

          <div className="shadow-lg p-6 rounded-xl">
            <h3 className="text-xl font-bold mb-3">
              AI Evaluation
            </h3>

            <p>
              Get detailed answer evaluation with scores and suggestions.
            </p>
          </div>

          <div className="shadow-lg p-6 rounded-xl">
            <h3 className="text-xl font-bold mb-3">
              Analytics Dashboard
            </h3>

            <p>
              Track performance and identify weak areas.
            </p>
          </div>

        </div>
      </section>

      <Footer />
    </>
  );
}

export default Landing;